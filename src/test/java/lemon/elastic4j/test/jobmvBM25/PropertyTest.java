package lemon.elastic4j.test.jobmvBM25;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

import org.junit.Test;

public class PropertyTest {

    @Test
    public void getProperty() {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(CompanyEsInfoV2.class);
            PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor pd : pds) {
                System.out.println(pd.getName() + "--" + pd);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
