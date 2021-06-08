package za.ac.cput.groupx30.entity;

/* Thaakir Ajouhaar - 217244394
 * Guide Entity
 *  7 June 2021
 */

public class Guide
{
    private String id;
    private String name;

    public Guide(Builder builder)
    {
        this.id = builder.id;
        this.name = builder.name;
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
}
