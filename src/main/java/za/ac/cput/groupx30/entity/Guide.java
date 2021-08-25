package za.ac.cput.groupx30.entity;

/* Thaakir Ajouhaar - 217244394
 * Guide Entity
 *  7 June 2021
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(Guide.GuideId.class)
public class Guide
{
    @Id
    private String id,name;

    public Guide(Builder builder)
    {
        this.id = builder.id;
        this.name = builder.name;
    }

    public Guide() {

    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public static class Builder
    {
        public String id;
        public String name;

        public Guide.Builder setId(String id)
        {
            this.id = id;
            return this;
        }

        public Guide.Builder setName(String name)
        {
            this.name = name;
            return this;
        }

        public Builder copy(Guide guide)
        {
            this.id = guide.id;
            this.name = guide.name;
            return this;
        }

        public Guide build()
        {
            return new Guide(this);
        }
    }

    @Override
    public String toString() {
        return "Guide{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public static class GuideId implements Serializable
    {
        private String id, name;

        public GuideId(String id, String name)
        {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Guide.GuideId that = (Guide.GuideId) o;
            return id.equals(that.id) && name.equals(that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }
}
