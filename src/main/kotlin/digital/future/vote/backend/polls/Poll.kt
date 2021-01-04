package digital.future.vote.backend.polls

import java.time.LocalDateTime
import java.time.ZonedDateTime

data class Poll(
    val id: Int?,
    val title: String,
    val description: String?,
    val timeStart: LocalDateTime,
    val timeEnd: LocalDateTime,
    val created: ZonedDateTime?
)
