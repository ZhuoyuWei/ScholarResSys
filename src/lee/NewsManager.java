package lee;

import org.crazyit.app.domain.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.*;
import com.mysql.jdbc.Driver;



public class NewsManager {
	
	public static void main(String[] args)
		throws Exception {
		//ʵ��Configuration��
		Configuration conf = new Configuration()
		//���淽��Ĭ�ϼ���hibernate.cfg.xml�ļ�
			.configure();
		//��Configuration����SessionFactory
		//@SuppressWarnings("deprecation")
		//SchemaExport export =new SchemaExport(conf);
		// export.drop(true, true);
		//export.create(true, true);
		//export.execute(true, true, true, true);

		SessionFactory sf = conf.buildSessionFactory();
		//����Session
		Session sess = sf.openSession();
		//��ʼ����
		Transaction tx = sess.beginTransaction();
		//������Ϣʵ��
		News n = new News();
		//������Ϣ�������Ϣ����
		n.setTitle("阿萨德");
		n.setContent("asd神经病");
		//������Ϣ
		sess.save(n);
		//�ύ����
		tx.commit();
		//�ر�Session
		sess.close();
		sf.close();
	}
}
