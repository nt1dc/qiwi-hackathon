import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "ValCurs")
class ValCurs {
    @field:Attribute(name = "name")
    lateinit var name: String

    @field:Attribute(name = "Date", required = false)
    lateinit var date: String

    @field:ElementList(inline = true, required = false)
    lateinit var valutes: MutableList<Valute>
}

@Root(name = "Valute")
data class Valute(
    @field:Attribute(name = "ID")
    var id: String? = null,
    @field:Element(name = "CharCode")
    var charCode: String? = null,
    @field:Element(name = "Value")
    var value: String? = null,
    @field:Element(name = "NumCode")
    var numCode: Int? = null,
    @field:Element(name = "Nominal")
    var nominal: Int? = null,
    @field:Element(name = "Name")
    var name: String? = null,

    )
