namespace WebApi.Services
{
    public class MathService
    {
        public int Average(params int[] values)
        {
            int sum = 0;

            for (int i = 0; i < values.Length; i++)
                sum += values[i];

            return sum / values.Length;
        }
    }
}
