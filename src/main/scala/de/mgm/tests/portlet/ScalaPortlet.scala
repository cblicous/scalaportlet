package de.mgm.tests.portlet


// import javax.portlet.GenericPortlet
import javax.portlet.{GenericPortlet => JavaPortlet}
import javax.portlet.RenderRequest
import javax.portlet.RenderResponse
import scala.collection.mutable.HashMap

// Implizite Conversion zwischen Java und scala :D
import collection.JavaConversions._

class ScalaPortlet extends JavaPortlet {
    override def doView(request: RenderRequest, response: RenderResponse) = {

        println("+++++++++ doView +++++++++")
        println("+++++++++ hello +++++++++")


        response.setTitle("Scala Test Portlet")
        response.getWriter().write(
            <div>
                <form action={response.createActionURL.toString} method="post">

                    <label>Einen Wert
                            <input name="wert" value="Hallo Welt"/>
                    </label>

                        <hr/>
                    <p>
                        <button name="save" value="save">Speichern</button>
                        <button name="cancel" value="cancel">Doch nicht</button>
                    </p>
                </form>
            </div>.toString)
    }

      override def processAction(request: javax.portlet.ActionRequest, response: javax.portlet.ActionResponse) = {
        println("++++ request recieved ++++");
        println("++++ Parameter ++++");


        request.getParameterMap  foreach  {
          case (key, value) => {
              println (key + " :" )
              println (request.getParameter(key))
          }
        }
  }
}