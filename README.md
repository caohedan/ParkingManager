"# ParkingManager" 
```
//1.创建停车场
//POST    url:/ParkingLots  response:true/false
  @PostMapping(path="/ParkingLots")
    public boolean addParkingLot(@RequestBody ParkingLot parkingLot)
    {
         return parkingLotService.addParkingLot(parkingLot);
    }
```
```
//2.创建   ParkingBoy
//POST    /ParkingBoys     response:true/false
 @PostMapping(path="/ParkingBoys")
    public boolean addParkingBoy(@RequestBody ParkingBoy parkingBoy)
    {
        return  parkingBoyService.addParkingBoy(parkingBoy);
    }
```
```
//3.给ParkingBoy安排停车场
//PUT  /ParkingBoys/{PBId} resquest:ParkingLot response：ParkingLot
  @PutMapping(path="/ParkingBoys/{PBId}")
    public List<ParkingLot> assignParkingLot(@RequestBody ParkingLot parkingLot, @PathVariable Long PBId)
    {
          return parkingBoyService.assignParkingLot(PBId,parkingLot);
    }
```