package za.ac.cput.groupx30.entity;

/* Thaakir Ajouhaar - 217244394
 * RouteGuide Entity
 *  7 June 2021
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class RouteGuide
{
    @Id
    private String routeId;
    private String guideId;

    public RouteGuide() {}

    private RouteGuide(Builder builder)
    {
        this.routeId = builder.routeId;
        this.guideId = builder.guideId;
    }

    public String getRouteId()
    {
        return routeId;
    }

    public String getGuideId()
    {
        return guideId;
    }

    @Override
    public String toString() {
        return "Builder{" +
                "routeId='" + routeId + '\'' +
                ", guideId='" + guideId + '\'' +
                '}';
    }

    public static class Builder
    {
        private String routeId;
        private String guideId;

        public Builder setRouteId(String routeId)
        {
            this.routeId = routeId;
            return this;
        }

        public Builder setGuideId(String guideId)
        {
            this.guideId = guideId;
            return this;
        }

        public Builder copy(RouteGuide routeGuide)
        {
            this.routeId = routeGuide.routeId;
            this.guideId = routeGuide.guideId;
            return this;
        }

        public RouteGuide build()
        {
            return new RouteGuide(this);
        }
    }
}
