package gr.demokritos.dtos;

import java.io.Serializable;

public abstract class AbstractDto implements Serializable {

    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof AbstractDto)) {
            return false;
        }
        AbstractDto other = (AbstractDto) obj;
        return getId().equals(other.getId());
    }
}
