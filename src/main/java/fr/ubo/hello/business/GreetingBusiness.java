package fr.ubo.hello.business;

import fr.ubo.hello.bean.Greeting;
import org.springframework.stereotype.Service;

@Service
public class GreetingBusiness {
        public Greeting greeting(String greetingParam){
            return new Greeting("Hello, "+greetingParam,"Hamza FELLAH");
        }
        public Greeting badGreeting(){
            return new Greeting("name est obligatoire. Merci de le renseigner.","Hamza FELLAH");
        }

    }