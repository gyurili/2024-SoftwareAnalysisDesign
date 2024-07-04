package hw.ch04.car;

import hw.ch04.framework.Product;

public class car_Parkgyuri extends Product {

    private String modelName;

    public car_Parkgyuri(String modelName) { //생성자로 모델명을 속성에 저장
        this.modelName = modelName;
    }

    @Override
    public void use() { //메시지 출력
        System.out.println("모델명 " + modelName + "인 car를 사용합니다");
    }

    @Override
    public String getModelName() { //자신의 모델명 반환
        return modelName;
    }

}
