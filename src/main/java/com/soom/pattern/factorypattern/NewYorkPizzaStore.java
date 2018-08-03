package com.soom.pattern.factorypattern;

public class NewYorkPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        if(type.equals("cheese")){
            return new NewYorkStyleCheesePizza();
        }else if(type.equals("veggie")){
            return new NewYorkStyleVeggiePizza();
        }else if(type.equals("clam")){
            return new NewYorkStyleClamPizza();
        }else if(type.equals("pepperoni")){
            return new NewYorkStylePepperoniPizza();
        }else return null;

    }
}
