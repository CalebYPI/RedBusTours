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

//@Entity
//@IdClass(RouteGuide.RouteGuideId.class)
public class RouteGuide implements Serializable
{
    //@Id
    private String routeId,guideId;

    public RouteGuide() {

    }

    public RouteGuide(Builder builder)
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

    public static class Builder
    {
        public String routeId;
        public String guideId;

        public RouteGuide.Builder setRouteId(String routeId)
        {
            this.routeId = routeId;
            return this;
        }


        public RouteGuide.Builder setGuideId(String guideId)
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

    @Override
    public String toString() {
        return "Builder{" +
                "routeId='" + routeId + '\'' +
                ", guideId='" + guideId + '\'' +
                '}';
    }

    public static class RouteGuideId implements Serializable
    {
        private String RouteId, GuideId;

        public RouteGuideId(String routeId, String guideId)
        {
            this.RouteId = routeId;
            this.GuideId = guideId;
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            RouteGuide.RouteGuideId that = (RouteGuide.RouteGuideId) o;
            return RouteId.equals(that.RouteId) && GuideId.equals(that.GuideId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(RouteId, GuideId);
        }
    }
}
