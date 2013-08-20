/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;

/**
 *
 * @author Bruno
 */
public interface DAO<T> {
    
    T loadByID(int id);
    
    
    /**
     * exemplo
     * 
     * private Criteria montarCriteria(String searchField, String searchString, FilterSearchUtil filter, String isBloqueioTipo) {
        Criteria criteria = session.createCriteria(Usuario.class, "usis");
        criteria.createCriteria("usis.entidadeFisica", "entf");
        criteria.createCriteria("entf.entidade", "enti");
        criteria.createCriteria("usis.regsPadroesUsis", "regsPadroesUsis");
        criteria.createCriteria("regsPadroesUsis.pais", "pais");
        criteria.createCriteria("regsPadroesUsis.estado", "esta");
        criteria.createCriteria("regsPadroesUsis.cidade", "cida");


        if (isBloqueioTipo.equals("isBloqueado") == false) {
            criteria.add(Restrictions.eq("usisIsBloqueado", "f"));
        } else if (isBloqueioTipo.equals("isBloqueado") == true) {
            criteria.add(Restrictions.eq("usisIsBloqueado", "t"));
        }

        if (searchField.equals("enti.entiPK.idp")) {
            Object _searchString;
            if (searchField.equals("enti.entiPK.idp")) {
                try {
                    _searchString = Long.parseLong(searchString);
                } catch (Exception e) {
                    _searchString = -1L;
                }
            } else {
                try {
                    _searchString = Integer.parseInt(searchString);
                } catch (Exception e) {
                    _searchString = -1;
                }
            }
            criteria.add(Restrictions.eq(searchField, _searchString));
        } else if (searchField.equals("usisLogin")) {

            criteria.add(Restrictions.eq(searchField, searchString));
        } else {
            criteria.add(Restrictions.ilike(searchField, searchString, MatchMode.ANYWHERE));
        }
        return criteria;
    }

    public Integer rowCount(String searchField, String searchString, FilterSearchUtil filter, String isBloqueioTipo) {
        Criteria criteria = montarCriteria(searchField, searchString, filter, isBloqueioTipo);
        criteria.setProjection(Projections.rowCount());
        return ((Integer) criteria.uniqueResult()).intValue();
    }

    public List<Object[]> loadByFilter(Integer pageNumber, Integer pageSize, String sidx, String sord, String searchField, String searchString, FilterSearchUtil filter, String isBloqueioTipo) {
        Criteria criteria = montarCriteria(searchField, searchString, filter, isBloqueioTipo);

        ProjectionList p = Projections.projectionList();
        p.add(Projections.groupProperty("usis.usuarioPK.idp"));
        p.add(Projections.groupProperty("usis.usuarioPK.ids"));
        
//        p.add(Projections.groupProperty("entf.entfPK.idp"));
//        p.add(Projections.groupProperty("entf.entfPK.ids"));
//                
//        p.add(Projections.groupProperty("enti.entiPK.idp"));
//        p.add(Projections.groupProperty("enti.entiPK.ids"));
        
        p.add(Projections.groupProperty("enti.entiNome"));
        p.add(Projections.groupProperty("usis.usisLogin"));

//        regsPadroesUsis.rpusPK.idp
        criteria.setProjection(p);

        criteria.setFirstResult((pageNumber - 1) * pageSize);
        criteria.setMaxResults(pageSize);
        //   criteria.addOrder(sord.equalsIgnoreCase("asc") ? Order.asc(sidx) : Order.desc(sidx));
        criteria.addOrder(Order.asc("enti.entiNome"));
        criteria.addOrder(Order.desc("usis.usisLogin"));

        return criteria.list();
    }
    
     */
}
