import com.google.firebase.messaging.FirebaseMessaging
import com.namangulati.studenthub.models.SentMessageDTO
import com.namangulati.studenthub.models.toMessage
import io.ktor.http.HttpStatusCode
import io.ktor.server.request.receiveNullable
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import org.apache.http.HttpStatus

fun Route.sendNotification() {
    route("/send") {
        post {
            val body = call.receiveNullable<SentMessageDTO>() ?: run {
                call.respond(HttpStatusCode.BadRequest)
                return@post
            }

            FirebaseMessaging.getInstance().send(body.toMessage())
            call.respond(HttpStatusCode.OK)
        }
    }

    route("/broadcast") {
        post {
            val body = call.receiveNullable<SentMessageDTO>() ?: run {
                call.respond(HttpStatusCode.BadRequest)
                return@post
            }

            FirebaseMessaging.getInstance().send(body.toMessage())
            call.respond(HttpStatusCode.OK)
        }
    }
}