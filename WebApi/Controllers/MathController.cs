using Microsoft.AspNetCore.Mvc;
using WebApi.Services;

namespace WebApi.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class MathController : ControllerBase
    {
        private readonly ILogger<MathController> _logger;
        private readonly MathService _mathService;

        public MathController(ILogger<MathController> logger, MathService mathService)
        {
            _mathService = mathService;
            _logger = logger;
        }


        [HttpPost(Name = "GetAverage")]
        public IActionResult GetAverage(params int[] values)
        {
            int average = _mathService.Average(values);

            return Ok(average);
        }

    }
}