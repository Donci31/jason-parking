+auction(ID, EXIT)[source(S)] : not occupied(park_place4) & auction(ID, 7)
   <- .send(S, tell, place_bid(EXIT, 2)).

+auction(ID, EXIT)[source(S)] : not occupied(park_place4) & auction(ID, 8)
   <- .send(S, tell, place_bid(EXIT, 2)).

+auction(ID, EXIT)[source(S)] : not occupied(park_place4) & not auction(ID, 7) & not auction(ID, 8)
   <- .send(S, tell, place_bid(EXIT, 1)).

+auction(ID, EXIT)[source(S)] : occupied(park_place4)
   <- .send(S, tell, place_bid(EXIT, 0)).
