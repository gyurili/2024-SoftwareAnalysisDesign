package practice.ch20;

import java.util.HashMap;
import java.util.Map;

// Bigchar의 인스턴스를 "공유"하며 생성 (싱글턴 패턴)
public class BigCharFactory {
    // 이미 만든 BigChar 인스턴스를 관리 
    private Map<String,BigChar> pool = new HashMap<>();
    // Singleton 패턴 
    private static BigCharFactory singleton = new BigCharFactory();

    // 생성자 
    private BigCharFactory() {
    }

    // 유일한 인스턴스를 얻는다
    public static BigCharFactory getInstance() {
        return singleton;
    }

    // BigChar 인스턴스 생성(공유)
    public synchronized BigChar getBigChar(char charname) { //"1"

        // 이미 만든게 있는지 찾아봄
        BigChar bc = pool.get(String.valueOf(charname)); //"1"

    
        if (bc == null) { //이미 만든게 없으면 ..
            // 여기서 BigChar 인스턴스를 생성 
            bc = new BigChar(charname);
            pool.put(String.valueOf(charname), bc); // 새로 만든 걸 보관함
        }
        return bc;
    }
}
