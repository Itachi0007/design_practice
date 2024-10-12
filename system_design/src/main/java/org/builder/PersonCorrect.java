package org.builder;

public class PersonCorrect {
    private final String name;
    private final String email;
    private final int age;
    private final String DOB;
    private final Long phone;

    // Private constructor, initializing final variables using the builder
    private PersonCorrect(PersonBuilder builder) {
        this.name = builder.name;   // Initialize required fields (final)
        this.email = builder.email; // Initialize required fields (final)
        this.age = builder.age;     // Initialize optional fields (final)
        this.DOB = builder.DOB;
        this.phone = builder.phone;
    }

    // Static inner Builder class
    public static class PersonBuilder {
        // Required parameters (final)
        private final String name;     // Required fields initialized in builder constructor
        private final String email;

        // Optional parameters - INITIALISED
        private int age = 0;
        private String DOB = "";
        private Long phone = 0L;

        // Constructor for required parameters (name and email)
        public PersonBuilder(String name, String email) {
            this.name = name;      // Final variables initialized in builder constructor
            this.email = email;
        }

        // Setter method for optional parameter: age
        public PersonBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        // Setter method for optional parameter: DOB
        public PersonBuilder setDOB(String DOB) {
            this.DOB = DOB;
            return this;
        }

        // Setter method for optional parameter: phone
        public PersonBuilder setPhone(Long phone) {
            this.phone = phone;
            return this;
        }

        // Build method to create the final Person object
        public PersonCorrect build() {
            return new PersonCorrect(this);  // Pass the builder instance to the Person constructor
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", DOB='" + DOB + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                '}';
    }
}