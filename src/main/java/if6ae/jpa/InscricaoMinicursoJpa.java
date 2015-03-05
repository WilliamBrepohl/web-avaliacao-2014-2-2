package if6ae.jpa;

import if6ae.entity.Inscricao;
import if6ae.entity.InscricaoMinicurso;
import if6ae.entity.InscricaoMinicursoPK_;
import if6ae.entity.InscricaoMinicurso_;
import if6ae.entity.Inscricao_;
import if6ae.entity.Minicurso;
import if6ae.entity.Minicurso_;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

public class InscricaoMinicursoJpa extends JpaController {

    public InscricaoMinicursoJpa() {
    }

    public List<Tuple> findInscricaoMinicursoByNumero(Integer num) {
        EntityManager em = null;
        em = getEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Tuple> cq = cb.createTupleQuery();
            Root<InscricaoMinicurso> r = cq.from(InscricaoMinicurso.class);
            Join<InscricaoMinicurso, Minicurso> joinInscricaoMinicurso = r.join(InscricaoMinicurso_.minicurso1);
            Join<Minicurso ,InscricaoMinicurso> joinMinicurso = joinInscricaoMinicurso.join(Minicurso_.inscricaoMinicursoList);
            Join<InscricaoMinicurso, Inscricao> joinInscricao = joinMinicurso.join(InscricaoMinicurso_.inscricao);
            cq.multiselect(joinInscricao.get(Inscricao_.numero), joinInscricao.get(Inscricao_.nome), joinInscricaoMinicurso.get(Minicurso_.codigo), joinInscricaoMinicurso.get(Minicurso_.descricao));
            cq.where(cb.equal(r.get(InscricaoMinicurso_.inscricaoMinicursoPK).get(InscricaoMinicursoPK_.numeroInscricao), num));
            TypedQuery<Tuple> q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            em.close();
        }
    }
}
