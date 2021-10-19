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
@IdClass(RouteGuide.RouteGuideId.class)
public class RouteGuide implements Serializable {
    @Id
    private String routeId, guideId;

    public RouteGuide() {
    }

    private RouteGuide(Builder builder) {
        this.routeId = builder.routeId;
        this.guideId = builder.guideId;
    }

    public String getRouteId() {
        return routeId;
    }

    public String getGuideId() {
        return guideId;
    }

    @Override
    public String toString() {
        return "Builder{" +
                "routeId='" + routeId + '\'' +
                ", guideId='" + guideId + '\'' +
                '}';
    }

    public static class Builder {
        private String routeId;
        private String guideId;

        public Builder setRouteId(String routeId) {
            this.routeId = routeId;
            return this;
        }

        public Builder setGuideId(String guideId) {
            this.guideId = guideId;
            return this;
        }

        public Builder copy(RouteGuide routeGuide) {
            this.routeId = routeGuide.routeId;
            this.guideId = routeGuide.guideId;
            return this;
        }

        public RouteGuide build() {
            return new RouteGuide(this);
        }
    }

    public static class RouteGuideId implements Serializable {
        public RouteGuideId() {
        }

        private String routeId, guideId;

        public RouteGuideId(String routeId, String guideId) {
            this.routeId = routeId;
            this.guideId = guideId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            RouteGuideId that = (RouteGuideId) o;
            return routeId.equals(that.routeId) && guideId.equals(that.guideId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(routeId, guideId);
        }
    }
}
