package com.dushi.designpatterns.bulder;

public class Car {
    private final String insurance;
    private final Boolean etc;//electronic tranfer
    private final String roadAssistance;
    private final String dropOffLocation;

    public Car(Builder builder){
        this.insurance = builder.insurance;
        this.etc=builder.etc;
        this.roadAssistance = builder.roadAssistance;
        this.dropOffLocation = builder.dropOffLocation;
    }

    static class Builder{
        String insurance;
        Boolean etc;
        String roadAssistance;
        String dropOffLocation;

        public Car build() {
            return new Car(this);
        }

        public Builder(String insurance) {
            this.insurance = insurance;
        }

        public Builder etc(Boolean etc) {
            this.etc = etc;
            return this;
        }

        public Builder roadAssistance(String roadAssistance) {
            this.roadAssistance = roadAssistance;
            return this;
        }

        public Builder dropOffLocation(String dropOffLocation) {
            this.dropOffLocation = dropOffLocation;
            return this;
        }

    }

    @Override
    public String toString() {
        return "Car{" +
                "insurance='" + insurance + '\'' +
                ", etc=" + etc +
                ", roadAssistance='" + roadAssistance + '\'' +
                ", dropOffLocation='" + dropOffLocation + '\'' +
                '}';
    }
}
