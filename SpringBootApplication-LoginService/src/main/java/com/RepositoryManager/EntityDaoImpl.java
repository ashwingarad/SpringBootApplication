package com.RepositoryManager;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

@SuppressWarnings("unchecked")
public abstract class EntityDaoImpl<T, PK extends Serializable> extends HibernateTemplate implements EntityDao<T, PK> {

    protected Class<T> entityClass;

    protected EntityDaoImpl() {
        this.entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    @Resource(name = "sessionFactory")
    public void setHibernateSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    private Session getSession() {
        Session session = null;
        try {
            session = getSessionFactory().getCurrentSession();
        } catch (Exception e) {
            session = getSessionFactory().openSession();
            System.out.println(e.getMessage());
        }
        return session;
    }


    public PK create(T newInstance) {
        setCheckWriteOperations(false);
        return (PK) save(newInstance);
    }


    public void create(Collection<T> newInstances) {
        if (newInstances == null)
            throw new IllegalArgumentException("ParameterMaster newInstances can not be null!");
        for (T newInstance : newInstances) {
            create(newInstance);
        }
    }

    public T read(PK id) {
        setCheckWriteOperations(true);
        return (T) get(entityClass, id);
    }

    public T load(PK id) {
        setCheckWriteOperations(true);
        return (T) load(entityClass, id);
    }

    public void updateObject(T transientObject) {
        setCheckWriteOperations(false);
        update(transientObject);
    }

    public T mergeObject(T transientObject) {
        return (T) merge(transientObject);
    }

    public void deleteObject(T persistenceObject) {
        setCheckWriteOperations(false);
        delete(persistenceObject);
    }

    public void deleteObjectCollection(Collection<T> persistenceObjects) {
        setCheckWriteOperations(false);
        deleteAll(persistenceObjects);
    }

    public void deleteByPrimaryKey(PK primaryKey) {
        Session session = getSessionFactory().openSession();
        session.delete(session.load(entityClass, primaryKey));
        session.beginTransaction().commit();
        session.close();
    }

    public List<T> listAll() {
        return (List<T>) createEntityCriteria().list();
    }

    public void evictObject(T persistenceObject) {
        setCheckWriteOperations(false);
        evict(persistenceObject);
    }

    public void flushSession() {
        flush();
    }

    public void flushAndClearSession() {
        flush();
        clear();
    }

    @SuppressWarnings("deprecation")
    protected Criteria createEntityCriteria(Class c, String alias) {
        String comment = getSQLComment();
        Criteria criteria = getSession().createCriteria(c, alias);
        criteria.setComment(comment);
        return criteria;
    }

    @SuppressWarnings("deprecation")
    protected Criteria createEntityCriteria(Class c) {
        String comment = getSQLComment();
        Criteria criteria = getSession().createCriteria(c);
        criteria.setComment(comment);
        return criteria;
    }

    protected Criteria createEntityCriteria() {
        return createEntityCriteria(entityClass);
    }

    protected CriteriaBuilder createCriteriaBuilder() {
        return getSession().getCriteriaBuilder();
    }

    protected NativeQuery<T> createSQLQuery(String queryString) {
        NativeQuery<T> query = getSession().createNativeQuery(queryString);
        query.setComment(getSQLComment());
        return query;
    }

    @SuppressWarnings("rawtypes")
    protected Query createQuery(String queryString) {
        Query query = getSession().createQuery(queryString);
        query.setComment(getSQLComment());
        return query;
    }

    protected Query createQuery(CriteriaQuery query) {
        return getSession().createQuery(query);
    }

    private String getSQLComment() {
        StringBuilder comment = new StringBuilder();
        StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : trace) {
            String clazz = element.getClassName();
            // little hack to filter out the actual dao call...
            if (clazz.contains("Ashwin") && !clazz.contains("Entity")) {
                comment.append(clazz.substring(clazz.lastIndexOf(".") + 1, clazz.length()));
                comment.append(".");
                comment.append(element.getMethodName());
                comment.append("()");
                break;
            }
        }
        return comment.toString();
    }

    protected HibernateTemplate getCachingQueriesHibernateTemplate() {
        return getCachingQueriesHibernateTemplate(null);
    }

    protected HibernateTemplate getCachingQueriesHibernateTemplate(String region) {
        this.setCacheQueries(true);

        if (region != null) {
            this.setQueryCacheRegion(region);
        }

        return this;
    }

    protected int updateByNamedQueryAndNamedParam(final String queryName, final String[] paramNames,
                                                  final Object[] paramValues) {

        final Query queryObject = getSession().getNamedQuery(queryName);

        if (paramValues != null) {
            for (int i = 0; i < paramValues.length; i++) {
                applyNamedParameterToQuery(queryObject, paramNames[i], paramValues[i]);
            }
        }
        return queryObject.executeUpdate();
    }

    protected void applyNamedParameterToQuery(Query queryObject, String paramName, Object value)
            throws HibernateException {

        if (value instanceof Collection) {
            queryObject.setParameterList(paramName, (Collection) value);
        } else if (value instanceof Object[]) {
            queryObject.setParameterList(paramName, (Object[]) value);
        } else {
            queryObject.setParameter(paramName, value);
        }
    }
}