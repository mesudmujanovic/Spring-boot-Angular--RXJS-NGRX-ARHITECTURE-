package springboot.Intergration;

public interface DTOmapper <T,C>{
    public <T> T apply(C c);
}
