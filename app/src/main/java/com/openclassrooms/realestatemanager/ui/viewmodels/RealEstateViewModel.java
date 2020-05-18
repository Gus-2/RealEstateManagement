package com.openclassrooms.realestatemanager.ui.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


import com.openclassrooms.realestatemanager.models.pojo.Address;
import com.openclassrooms.realestatemanager.models.pojo.House;
import com.openclassrooms.realestatemanager.models.pojo.HouseDateState;
import com.openclassrooms.realestatemanager.models.pojo.HousePointOfInterest;
import com.openclassrooms.realestatemanager.models.pojo.HouseType;
import com.openclassrooms.realestatemanager.models.pojo.Photo;
import com.openclassrooms.realestatemanager.models.pojo.PointOfInterest;
import com.openclassrooms.realestatemanager.models.pojo.RealEstateAgent;
import com.openclassrooms.realestatemanager.models.pojo.Room;
import com.openclassrooms.realestatemanager.models.pojo.RoomNumber;
import com.openclassrooms.realestatemanager.models.pojo.TypePointOfInterest;
import com.openclassrooms.realestatemanager.repositories.AddressDataRepository;
import com.openclassrooms.realestatemanager.repositories.PointOfInterestDataRepository;
import com.openclassrooms.realestatemanager.repositories.HouseDataRepository;
import com.openclassrooms.realestatemanager.repositories.HousePointOfInterestDataRepository;
import com.openclassrooms.realestatemanager.repositories.HouseTypeDataRepository;
import com.openclassrooms.realestatemanager.repositories.PhotoDataRepository;
import com.openclassrooms.realestatemanager.repositories.RealEstateAgentDataRepository;
import com.openclassrooms.realestatemanager.repositories.RoomDataRepository;
import com.openclassrooms.realestatemanager.repositories.RoomNumberDataRepository;
import com.openclassrooms.realestatemanager.repositories.TypePointOfInterestDataRepository;

import java.util.List;
import java.util.concurrent.Executor;

public class RealEstateViewModel extends ViewModel {

    private final AddressDataRepository addressDataRepository;
    private final HouseDataRepository houseDataRepository;
    private final HousePointOfInterestDataRepository housePointOfInterestDataRepository;
    private final HouseTypeDataRepository houseTypeDataRepository;
    private final PhotoDataRepository photoDataRepository;
    private final PointOfInterestDataRepository pointOfInterestDataRepository;
    private final RealEstateAgentDataRepository realEstateAgentDataRepository;
    private final RoomNumberDataRepository roomNumberDataRepository;
    private final RoomDataRepository roomDataRepository;
    private final TypePointOfInterestDataRepository typePointOfInterestDataRepository;
    private final Executor executor;

    public RealEstateViewModel(AddressDataRepository addressDataRepository, HouseDataRepository houseDataRepository, HousePointOfInterestDataRepository housePointOfInterestDataRepository, HouseTypeDataRepository houseTypeDataRepository, PhotoDataRepository photoDataRepository, PointOfInterestDataRepository pointOfInterestDataRepository, RealEstateAgentDataRepository realEstateAgentDataRepository, RoomNumberDataRepository roomNumberDataRepository, RoomDataRepository roomDataRepository, TypePointOfInterestDataRepository typePointOfInterestDataRepository, Executor executor) {
        this.addressDataRepository = addressDataRepository;
        this.houseDataRepository = houseDataRepository;
        this.housePointOfInterestDataRepository = housePointOfInterestDataRepository;
        this.houseTypeDataRepository = houseTypeDataRepository;
        this.photoDataRepository = photoDataRepository;
        this.pointOfInterestDataRepository = pointOfInterestDataRepository;
        this.realEstateAgentDataRepository = realEstateAgentDataRepository;
        this.roomNumberDataRepository = roomNumberDataRepository;
        this.roomDataRepository = roomDataRepository;
        this.typePointOfInterestDataRepository = typePointOfInterestDataRepository;
        this.executor = executor;
    }

    //Address
    public LiveData<Address> getAddress(int address) {
        return addressDataRepository.getAddress(address);
    }

    public List<Address> getAddress() {
        return addressDataRepository.getAddress();
    }

    public long insertAddress(Address address){
        return  addressDataRepository.insertAddress(address);
    }

    //House
    public LiveData<List<House>> getHouseData() {
        return houseDataRepository.getHouses();
    }

    public long insertHouse(House house) {
            return houseDataRepository.insertHouse(house);
    }

    public void updateSoldDate(long soldDate, long houseId, String state){
        executor.execute(() ->
          houseDataRepository.updateSoldDate(soldDate, houseId, state)
        );
    }

    public LiveData<HouseDateState> getHouseSate(long idHouse){
        return houseDataRepository.getHouseState(idHouse);
    }

    // House's point of interest
    public LiveData<List<HousePointOfInterest>> getHousePointOfInterest() {
        return housePointOfInterestDataRepository.getHousePointOfInterest();
    }

    public void insertHousePointOfInterest(HousePointOfInterest housePointOfInterest) {
        executor.execute(() -> {
            housePointOfInterestDataRepository.insertHousePointOfInterest(housePointOfInterest);
        });
    }

    public List<HousePointOfInterest> getHousePointOfInterestFromHouseId(long idHouse){
        return housePointOfInterestDataRepository.getHousePointOfInterestFromHouseId(idHouse);
    }

    // House's type
    public List<HouseType> getHouseType() {
        return houseTypeDataRepository.getHouseType();
    }

    public void insertHouseType(HouseType houseType) {
        executor.execute(() -> {
            houseTypeDataRepository.insertHouseType(houseType);
        });
    }

    // Photo
    public List<Photo> getPhoto() {
        return photoDataRepository.getPhotos();
    }

    public void insertPhoto(Photo photo) {
        executor.execute(() -> {
            photoDataRepository.insertPhoto(photo);
        });
    }

    // Point of interest
    public LiveData<List<PointOfInterest>> getPointOfInterest() {
        return pointOfInterestDataRepository.getPointOfInterest();
    }

    public long insertPointOfInterest(PointOfInterest pointOfInterest) {
        return pointOfInterestDataRepository.insertPointOfInterest(pointOfInterest);
    }

    public PointOfInterest getPointOfInterestFromId(long idPointOfInterest){
        return pointOfInterestDataRepository.getPointOfInterestFromId(idPointOfInterest);
    }

    // Real Estate Agent
    public List<RealEstateAgent> getRealEstateAgent() {
        return realEstateAgentDataRepository.getRealEstateAgent();
    }

    public void insertRealEstateAgent(RealEstateAgent realEstateAgent) {
        executor.execute(() -> {
            realEstateAgentDataRepository.insertRealEstateAgent(realEstateAgent);
        });
    }

    // Room
    public List<Room> getRoom() {
        return roomDataRepository.getRooms();
    }

    public void insertRoom(Room room) {
        executor.execute(() -> {
            roomDataRepository.insertRoom(room);
        });
    }

    // Room Number
    public LiveData<List<RoomNumber>> getRoomNumber() {
        return roomNumberDataRepository.getRoomNumber();
    }

    public void insertRoomNumber(RoomNumber roomNumber) {
        executor.execute(() -> {
            roomNumberDataRepository.insertRoomNumber(roomNumber);
        });
    }

    public List<RoomNumber> getRoomNumberForHouse(long idHouse){
        return roomNumberDataRepository.getRoomForHouse(idHouse);
    }

    // Type Point Of Interest
    public LiveData<List<TypePointOfInterest>> getTypePointOfInterest() {
        return typePointOfInterestDataRepository.getTypePointOfInterest();
    }

    public long insertTypePointOfInterest(TypePointOfInterest typePointOfInterest) {
        return typePointOfInterestDataRepository.insertTypePointOfInterest(typePointOfInterest);
    }

    public Integer getidTypePointOfInterest(String name){
        return typePointOfInterestDataRepository.getIdTypePointOfInterest(name);
    }

    public TypePointOfInterest getTypePointOfInterest(long idTypePointOfInterest){
        return typePointOfInterestDataRepository.getTypePointOfInterest(idTypePointOfInterest);
    }

}