import scala.util.Random

class CustomerID(name:String) {

  def apply(name: String) = s"$name--${Random.nextLong}"

  def unapply(customerID: String): Option[String] = {
    val name = customerID.split("--").head
    if (name.nonEmpty) Some(name) else None
  }

  def main(args: Array[String]): Unit = {
    val customer1ID = new CustomerID("Sukyoung")  // Sukyoung--23098234908
    val customer2ID = CustomerID("Sukyoung")  // Sukyoung--23098234908
    //val customer2ID = new CustomerID("Sukyoung")  // Sukyoung--23098234908
    println(customer1ID)
    customer1ID match {
      case CustomerID(name) => println(name)  // prints Sukyoung
      case _ => println("Could not extract a CustomerID")
    }

    println(customer2ID)
    customer2ID match {
      case CustomerID(name) => println(name)  // prints Sukyoung
      case _ => println("Could not extract a CustomerID")
    }
  }
  case class CustomerID(str: String)
}

