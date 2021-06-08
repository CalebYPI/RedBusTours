package za.ac.cput.groupx30.entity;

/* Thaakir Ajouhaar - 217244394
 * RouteGuide Entity
 *  7 June 2021
 */

public class RouteGuide
{
    private String routeId;
    private String guideId;

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
}
