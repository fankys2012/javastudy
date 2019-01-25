import com.starcor.util.JedisClient;

/**
 * @author chaozhong.leng <chaozhong.leng@starcor.com>
 * @Date 2018-02-26 17:10
 */
public class test {
    public static void main(String argv[]) throws Exception {
        JedisClient jedisClient = JedisClient.getInstance();
        boolean st = jedisClient.set("name","zhangsan");

        System.out.println(jedisClient.get("name"));
    }
}

