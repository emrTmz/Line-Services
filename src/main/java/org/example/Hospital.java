package org.example;

public class Hospital {
    public static void main(String[] args){
        int total_grade = 0;
        Patient p1, p2, p3;
        Service_1 service_1 = new Service_1();
        Service_2 service_2 = new Service_2();


        service_1.insert("patient_1");
        service_1.insert("patient_2");
        service_1.insert("patient_3", 1);
        service_1.insert("patient_4");
        service_1.insert("patient_5", 1);
        service_1.insert("patient_6");
        service_1.insert("patient_7");
        service_1.insert("patient_8", 2);
        service_1.insert("patient_9");
        service_1.insert("patient_10", 0);

        System.out.println("----------------Service 1----------------");
        service_1.print();



        System.out.println("----------------Service 1----------------");
        service_1.print();



        service_2.enqueue(new Patient("patient_21"));
        service_2.enqueue(new Patient("patient_22"));
        service_2.enqueue(new Patient("patient_23"));
        service_2.enqueue(new Patient("patient_24"));
        service_2.enqueue(new Patient("patient_25"));
        service_2.enqueue(new Patient("patient_26"));
        service_2.enqueue(new Patient("patient_27"));
        service_2.enqueue(new Patient("patient_28"));
        service_2.enqueue(new Patient("patient_29"));
        service_2.enqueue(new Patient("patient_30"));

        System.out.println("----------------Service 2----------------");
        service_2.queue.print();


        System.out.println("----------------Service 2----------------");
        service_2.queue.print();




    }

}
