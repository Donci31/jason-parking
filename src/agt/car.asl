+wants_to_exit_at(EXIT): not parked(self)
    <-  .print("I want to exit at ", EXIT);
        .send(gate, tell, wants_to_park(EXIT)).