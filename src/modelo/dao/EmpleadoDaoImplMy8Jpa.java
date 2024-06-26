package modelo.dao;

import java.math.BigDecimal;
import java.util.List;


import modelo.entidades.Empleado;

public class EmpleadoDaoImplMy8Jpa  extends AbstractDaoImplMy8Jpa implements EmpleadoDao{
	
	public EmpleadoDaoImplMy8Jpa() {
		super();
	}

	@Override
	public boolean alta(Empleado obj) {
		try {
			tx.begin();
				em.persist(obj);
			tx.commit();
			return true;
		}catch(Exception e) {
		//	e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
			
		}
	}

	@Override
	public boolean eliminar(Integer clave) {
		try {
			Empleado empleado = buscarUno(clave);
			if (empleado != null) {
				tx.begin();
					em.remove(empleado);
				tx.commit();
				return true;
			}else
				return false;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Empleado buscarUno(Integer clave) {
		// TODO Auto-generated method stub
		return em.find(Empleado.class, clave);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> mostrarTodos() {
		jpql = "select e from Empleado e";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public String salir() {
		// TODO Auto-generated method stub
		return "-----FIN DE PROGRAMA CRAK-----";
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> empleadosByDepartamento(int idDepar) {
		jpql= "select e from Empleado e where e.departamento.idDepar = :dep";
		query = em.createQuery(jpql);
		query.setParameter("dep", idDepar);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> empleadosBySexo(String sexo) {
		jpql= "select e from Empleado e where e.genero = :sex ";
		query = em.createQuery(jpql);
		query.setParameter("sex", sexo);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> empleadosByApellido(String subcadena) {
		jpql= "select e from Empleado e where e.apellidos = :apell";
		query = em.createQuery(jpql);
		query.setParameter("apell", subcadena);
		return query.getResultList();
	}

	@Override
	public double salarioTotal() {
		jpql = "select sum(e.salario) from Empleado e";
		query = em.createQuery(jpql);
		return ((BigDecimal)query.getSingleResult()).doubleValue();
	}

	@Override
	public double salarioTotal(int idDepar) {
		jpql = "select sum(e.salario) from Empleado e where e.departamento.idDepar = :salario";
		query = em.createQuery(jpql);
		query.setParameter("salario", idDepar);
		return ((BigDecimal)query.getSingleResult()).doubleValue();
	}

}
