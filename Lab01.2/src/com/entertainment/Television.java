package com.entertainment;

import java.util.Objects;

public class Television implements Comparable<Television>{
    private String brand;
    private int volume;
    private final Tuner tuner = new Tuner();

    public Television() {

    }

    public Television(String brand, int volume) {
        setBrand(brand);
        setVolume(volume);
    }

    public int getCurrentChannel() {
        return tuner.getChannel();
    }

    public void changeChannel(int channel) {
        tuner.setChannel(channel);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Television that = (Television) obj;
        return getVolume() == that.getVolume() && Objects.equals(getBrand(), that.getBrand());
    }

    @Override
    public int hashCode() {
        // a poorly written hash function, it easily results in "hash collisions"
        // i.e., "different" objects can easily yield the same hashcode
        // return getBrand().length() + getVolume();

        // instead, we use Objects.hash() to give us a scientifically correct hash function
        return Objects.hash(getBrand(), getVolume());
    }

    /*
    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        if (obj instanceof Television other) {
            result = Objects.equals(this.getBrand(), other.getBrand())
                    && this.getVolume() == other.getVolume();
        }

        return result;
    }
    */

    @Override
    public int compareTo(Television that) {
        int brandComparison =  this.getBrand().compareTo(that.getBrand());
        if (brandComparison == 0) {
            return this.getVolume() - that.getVolume();
        }

        return brandComparison;
    }

    @Override
    public String toString() {
        return Television.class.getSimpleName() + "[brand=" + getBrand() + ", volume=" + getVolume() + ", channel=" + getCurrentChannel() + "]";
    }
}