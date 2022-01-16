Description:
Implement a cab booking application. Below are the expected features from the system.
Features:
1. The application allows users to book rides on a route.
2. Users can register themself and make changes to their details.
3. Driving partner can onboard on the system with the vehicle details
4. Users can search and select one from multiple available rides on a route with the same
source and destination based on the nearest to the user
Requirements:
1. Application should allow user onboarding.
a. add_user(user_detail)
i. Add basic user details
b. update_user(username, updated_details)
i. User should be able to update its contact details
c. update_userLocation(username,Location):
i. This will update the user location in X , Y coordinate to find nearest in
future
2. Application should allow Driver onboarding
a. add_driver(driver_details,vehicle_details,current_location)
i. This will create an instance of the driver and will mark his current location
on the map
b. update_driverLocation(driver_name)
i. This will mark the current location of driver
c. change_driver_status(driver_name,status)
i. In this driver can make himself either available or unavailable via a
boolean
3. Application should allow the user to find a ride based on the criteria below
a. find_ride (Username,Source , destination)
i. It will return a list of available ride
b. choose_ride(Username,drive_name)
i. It will choose the drive name from the list
Note : Only the driver which is at a max distance of 5 unit will be displayed to a user and
the driver should be in available state to confirm the booking
c. calculateBill(Username):
i. It will return the bill based on the distance between the source and
destination and will display it
4. Application should at the end calculate the earning of all the driver onboarded in the
application find_total_earning()
