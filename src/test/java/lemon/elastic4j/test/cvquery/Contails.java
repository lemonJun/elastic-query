//package lemon.elastic4j.test.cvquery;
//
//import org.junit.Test;
//
//import com.alibaba.fastjson.JSON;
//import com.bj58.chr.scf.cvsearch.entity.CVCriteriaBean;
//import com.bj58.chr.scf.cvsearch.entity.CVIndexBean;
//
//import core.ESTemplateClient;
//import lemon.elastic.query4j.BootStrap;
//import lemon.elastic.query4j.esproxy.core.query.CriteriaQuery;
//import lemon.elastic.query4j.esproxy.domain.Page;
//import lemon.elastic.query4j.provider.CriteriaQueryGene;
//import lemon.elastic.query4j.provider.ElasticCriteriaQueryGene;
//
//public class Contails {
//
//    @Test
//    public void lnglatqy() {
//        BootStrap.init();
//        CVCriteriaBean bean = new CVCriteriaBean();
//        bean.setCollege("垌镇");
//        CriteriaQueryGene gene = new ElasticCriteriaQueryGene();
//        CriteriaQuery query = gene.geneESQueryPageable(JSON.toJSONString(bean), CVCriteriaBean.class, 0, 10);
//        Page<CVIndexBean> list = ESTemplateClient.getInstance().getTemplate().queryForPage(query, CVIndexBean.class);
//        for (CVIndexBean cv : list) {
//            System.out.println(JSON.toJSON(cv));
//        }
//    }
//
//}
