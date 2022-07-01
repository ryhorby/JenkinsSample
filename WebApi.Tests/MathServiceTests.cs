using WebApi.Services;

namespace WebApi.Tests
{
    public class MathServiceTests
    {
        private MathService _mathService;

        [SetUp]
        public void Setup()
        {
            _mathService = new MathService();
        }

        [Test]
        public void Average_ArrayFrom1To3_2returned()
        {
            //arrange
            int[] values = { 1, 2, 3 };
            int expected = 2;

            //act
            int actual = _mathService.Average(values);

            //assert
            Assert.That(actual, Is.EqualTo(expected));
        }
    }
}