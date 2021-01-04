package digital.future.vote.backend.polls

object PollsController {
    fun getAllPolls():Array<Poll> {
        throw NotImplementedError()
    }

    fun createPoll(poll: Poll): Poll {
        throw NotImplementedError()
    }

    fun getPoll(id: Int): Poll {
        throw NotImplementedError()
    }

    fun updatePoll(poll: Poll) {
        throw NotImplementedError()
    }

    fun deletePoll(id: Int) {
        throw NotImplementedError()
    }
}