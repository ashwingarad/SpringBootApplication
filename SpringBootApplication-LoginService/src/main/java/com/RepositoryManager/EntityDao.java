package com.RepositoryManager;
/*
 * @author Ashwin Garad
 * */

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface EntityDao<T, PK extends Serializable> {
    /**
     * Creates objects in the database
     *
     * @param newInstance object to create
     * @return primary key of the created object
     */
    PK create(T newInstance);


    /**
     * Creates objects in the database
     *
     * @param newInstances objects to create
     */
    void create(Collection<T> newInstances);

    /**
     * Return the persistent instance of the given entity class with the given identifier,
     * or null if there is no such persistent instance. (If the instance is already associated
     * with the session, return that instance. This method never returns an uninitialized instance.)
     * Obtain the specified lock mode if the instance exists.
     *
     * @param id an identifier
     * @return a persistent instance or null
     */
    T read(PK id);

    /**
     * Return the persistent object with the given identifier, assuming that the instance exists.
     * This method might return a proxied instance that is initialized on-demand, when a non-identifier
     * method is accessed.
     * <p/>
     * You should not use this method to determine if an instance exists (use <tt>get()</tt>
     * instead). Use this only to retrieve an instance that you assume exists, where non-existence
     * would be an actual error.
     *
     * @param id a valid identifier of an existing persistent instance of the class
     * @return the persistent instance or proxy
     */
    T load(PK id);

    /**
     * Update the persistent object with the identifier of the given detached
     * instance. If there is a persistent instance with the same identifier,
     * an exception is thrown. This operation cascades to associated instances
     * if the association is mapped with <tt>cascade="save-update"</tt>.
     *
     * @param transientObject a detached instance containing updated state
     */
    void updateObject(T transientObject);

    /**
     * Copy the state of the given object onto the persistent object with the same
     * identifier. If there is no persistent instance currently associated with
     * the session, it will be loaded. Return the persistent instance. If the
     * given instance is unsaved, save a copy of and return it as a newly persistent
     * instance. The given instance does not become associated with the session.
     * This operation cascades to associated instances if the association is mapped
     * with <tt>cascade="merge"</tt>.<br>
     *
     * @param transientObject a detached instance with state to be copied
     * @return an updated persistent instance
     */
    public T mergeObject(T transientObject);

    /**
     * Deletes persistent object from the database
     *
     * @param persistenceObject object to be deleted
     */
    void deleteObject(T persistenceObject);

    /**
     * Deletes persistent objects from the database
     *
     * @param persistenceObjects objects to be deleted
     */
    void deleteObjectCollection(Collection<T> persistenceObjects);

    /**
     * Deletes object from the database by its Primary Key.
     *
     * @param primaryKey The primary Key of the persistent Object.
     */
    void deleteByPrimaryKey(PK primaryKey);

    /**
     * Returns a list of all database objects for this type.
     * <p/>
     * <b>WARNING:</b> This can crash the JVM if done on unbounded tables, use with caution!
     *
     * @return List of all entities of this type.
     */
    List<T> listAll();

    /**
     * removes persistent object from cache
     *
     * @param persistenceObject
     */
    void evictObject(T persistenceObject);

    /**
     * flushes the current Hibernate Session (executes all the stmts in the session)
     * and clears it
     */
    void flushAndClearSession();

    /**
     * flushes the current Hibernate Session (executes all the stmts in the session)
     */
    void flushSession();
}
