import org.scalatest.Inspectors
import org.scalatest._

/**
 * @author dgordon
 */
abstract class TestBase extends FlatSpec
with Matchers with OptionValues
with Inside with Inspectors{
}
