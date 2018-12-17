
class ShortestTime
{
    private Double[][] pts;
    private Double below_speed, above_speed;
    private Integer num_div = 10;

    ShortestTime(Double[][] pts, Double below_speed, Double above_speed)
    {
        this.pts = pts;
        this.below_speed = below_speed;
        this.above_speed = above_speed;
    }

    private Double getTime(Double[][] pts, Double speed)
    {
        return Math.sqrt(Math.pow(pts[1][1] - pts[0][1], 2) + Math.pow(pts[1][0] - pts[0][0], 2))/speed;
    }

    private Double totTime(Double x)
    {
        return getTime(new Double[][]{pts[0], {x, 0.0}}, (pts[0][1]<0)? below_speed : above_speed)
                + getTime(new Double[][]{{x, 0.0}, pts[1]}, (pts[1][1]<0)? below_speed : above_speed);
    }

    Double[] optimize(Double start, Double end)
    {
        final Double fraction = (end-start)/num_div;
        Double min_time = totTime(start);
        Double best_x = start;

        for(Double i=start+fraction; i<=end; i+=fraction)
            if(totTime(i) < min_time)
            {
                best_x = i;
                min_time = totTime(i);
            }

        System.out.printf("%f\t %f\t %f\n", start, best_x, end);
        System.out.printf("%f\t %f\t %f\n\n", totTime(start), min_time, totTime(end));

        return new Double[] {best_x-fraction, best_x+fraction};
    }

    void find_best()
    {
        Double[] start_end = new Double[] {pts[0][0]-0.000000000001, pts[1][0]};
        for (int i = 0; i < 5; i++)
            start_end = optimize(start_end[0], start_end[1]);

        Double avg = (start_end[0] + start_end[1])/2;
        System.out.println(totTime(avg));
    }
}

class ShortestTimeDriver
{
    public static void main(String[] args)
    {
        ShortestTime obj = new ShortestTime(new Double[][]
                {{-2.0,-2.0}, {0.0,-0.0}}, 1.0, 8.0); // x must be increasing
        obj.find_best();
    }
}
