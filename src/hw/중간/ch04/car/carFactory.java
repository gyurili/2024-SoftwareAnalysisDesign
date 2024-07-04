package hw.ch04.car;

import java.util.Vector;
import java.util.Iterator;

import hw.ch04.framework.Product;
import hw.ch04.framework.Factory;

public class carFactory extends Factory {

    private Vector<String> modelNames = new Vector<>(); //제품들의 모델명을 저장

    @Override
    protected Product createProduct(String modelName) { //입력된 모델명 car를 생성, 반환
        return new car_Parkgyuri(modelName);
    }

    @Override
    protected void registerProduct(Product product) { 
        modelNames.add(product.getModelName()); //모델명을 modelNames에 추가함
    }

    public void printAllModelNames() { //modelNames에 저장되어 있는 모델명을 순회하며 출력

        System.out.println("<모델명 리스트>");

        Iterator<String> iterator = modelNames.iterator(); 
        while (iterator.hasNext()) { 
            String modelName = iterator.next(); 
            System.out.println(modelName);
        }
        
    }

}
