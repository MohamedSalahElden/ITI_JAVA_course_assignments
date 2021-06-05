package CitiesAndCountries;

import java.util.List;

public interface DAO<t>{
    public abstract List<t> getData(String path); 
}
