package com.model;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * A data access object (DAO) providing persistence and search support for
 * Userlist entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.model.Userlist
 * @author MyEclipse Persistence Tools
 */
public class UserlistDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(UserlistDAO.class);
	// property constants
	public static final String USERPASSWORD = "userpassword";

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Userlist transientInstance) {
		log.debug("saving Userlist instance");
		try {
//			Session session=getSession();
//			session.beginTransaction();//开始事务
//			session.save(transientInstance);
//			session.getTransaction().commit();//提交
//			session.flush();    //清空缓存  
//			session.close();
			getSession().save(transientInstance);
			getSession().flush();    //清空缓存 使之立即执行事务，否则可能只是语句执行成功，但是事务没有执行 
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Userlist persistentInstance) {
		log.debug("deleting Userlist instance");
		try {
//			Session session=getSession();
//			session.beginTransaction();//开始事务
//			getSession().delete(persistentInstance);
//			session.getTransaction().commit();//提交
//			session.flush();    //清空缓存  
//			session.close();
			getSession().delete(persistentInstance);
			getSession().flush();    //清空缓存 使之立即执行事务，否则可能只是语句执行成功，但是事务没有执行
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	public Userlist findById(java.lang.String id) {
		log.debug("getting Userlist instance with id: " + id);
		try {
			Userlist instance = (Userlist) getSession().get(
					"com.model.Userlist", id);
			getSession().flush();    //清空缓存 使之立即执行事务，否则可能只是语句执行成功，但是事务没有执行
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Userlist instance) {
		log.debug("finding Userlist instance by example");
		try {
			List results = getSession().createCriteria("com.model.Userlist")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			getSession().flush();    //清空缓存 使之立即执行事务，否则可能只是语句执行成功，但是事务没有执行
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Userlist instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Userlist as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			getSession().flush();    //清空缓存 使之立即执行事务，否则可能只是语句执行成功，但是事务没有执行
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserpassword(Object userpassword) {
		return findByProperty(USERPASSWORD, userpassword);
	}

	public List findAll() {
		log.debug("finding all Userlist instances");
		try {
			String queryString = "from Userlist";
			Query queryObject = getSession().createQuery(queryString);
			getSession().flush();    //清空缓存 使之立即执行事务，否则可能只是语句执行成功，但是事务没有执行
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Userlist merge(Userlist detachedInstance) {
		log.debug("merging Userlist instance");
		try {
			Userlist result = (Userlist) getSession().merge(detachedInstance);
			getSession().flush();    //清空缓存 使之立即执行事务，否则可能只是语句执行成功，但是事务没有执行
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Userlist instance) {
		log.debug("attaching dirty Userlist instance");
		try {
			getSession().saveOrUpdate(instance);
			getSession().flush();    //清空缓存 使之立即执行事务，否则可能只是语句执行成功，但是事务没有执行
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Userlist instance) {
		log.debug("attaching clean Userlist instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			getSession().flush();    //清空缓存 使之立即执行事务，否则可能只是语句执行成功，但是事务没有执行
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}