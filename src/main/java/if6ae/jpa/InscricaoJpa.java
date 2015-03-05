package if6ae.jpa;

import if6ae.entity.Inscricao;
import if6ae.entity.Inscricao_;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class InscricaoJpa extends JpaController {

    public InscricaoJpa() {
    }

    public List<Inscricao> findByNumero(Integer num) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Inscricao> cq = cb.createQuery(Inscricao.class);
            Root<Inscricao> rt = cq.from(Inscricao.class);
            cq.where(cb.equal(rt.get(Inscricao_.numero), num));
            TypedQuery<Inscricao> q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Inscricao> findByCpf(Long cpf) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Inscricao> cq = cb.createQuery(Inscricao.class);
            Root<Inscricao> rt = cq.from(Inscricao.class);
            cq.where(cb.equal(rt.get(Inscricao_.cpf), cpf));
            TypedQuery<Inscricao> q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
