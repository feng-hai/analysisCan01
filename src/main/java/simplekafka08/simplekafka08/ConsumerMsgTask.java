package simplekafka08.simplekafka08;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gimis.emcs.ps.msg.Message;

import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;

public class ConsumerMsgTask implements Runnable {
	private KafkaStream m_stream = null;
	private int m_threadNumber;
	private static int count = 0;

	private static final Logger LOG = LoggerFactory.getLogger(ConsumerMsgTask.class);

	public ConsumerMsgTask(KafkaStream stream, int threadNumber) {
		m_threadNumber = threadNumber;
		m_stream = stream;
	}

	public void run() {

		ExecutorService executor = Executors.newFixedThreadPool(50);
		ConsumerIterator<byte[], byte[]> it = m_stream.iterator();
		if (it == null) {
			return;
		}

		while (it.hasNext()) {
			// lock.lock();
			try {
				// count++;
				// System.out.println(count);

				// String temp=
				//

				// byte[] temp=it.next().message();

				byte[] message = it.next().message();

				if (message != null && message.length > 0) {
					 executor.submit(new HandleThread(message));

				     //executor.submit(new HandleThreadForStatus(message));
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("ConsumerMsgTask-run");
				e.printStackTrace();
			} finally {
				// System.out.println(m_threadNumber+"释放了锁");
				// lock.unlock();
			}

			// LOG.debug(temp);
		}
		System.out.println("Shutting down Thread: " + m_threadNumber);
	}
}