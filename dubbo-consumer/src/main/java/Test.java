import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by dy on 16-4-18.
 */
public class Test {

    public static void testSeckill(String name) throws Exception{

//        String get_url = "http://localhost:8080/seckillcs/seckill?name="+name;
        String get_url = "http://localhost:8080/seckillcs/preselection?name="+name;
        URL url = new URL(get_url);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect();

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));

        String line = "";
        while ((line=reader.readLine())!=null){
            System.out.println(line);
        }
        reader.close();
        connection.disconnect();
    }

    public static void main(String[] args) throws Exception{
        long curr = System.currentTimeMillis();
        for (int i = 0; i <100 ; i++) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        String name = "邓洋"+Thread.currentThread().getId();
                        Test.testSeckill(name);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
