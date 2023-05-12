+start_auction(ID, EXIT)
    <- .broadcast(tell, auction(ID, EXIT)).


@pb1[atomic]
+place_bid(N, _)
   :  .findall(b(B, A), place_bid(N, B)[source(A)], L) &
      .length(L, 4) &
      .max(L, b(B, W)) &
      B > 0
   <- .print("Winner of exit ", N, " is ", W);
      .send(W, tell, occupied(W));
      .abolish(place_bid(N, _)).
