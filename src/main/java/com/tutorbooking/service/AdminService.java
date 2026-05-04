package com.tutorbooking.service;

import com.tutorbooking.model.Admin;
import com.tutorbooking.model.Booking;
import com.tutorbooking.model.Tutor;
import com.tutorbooking.model.User;
import com.tutorbooking.model.Payment;
import com.tutorbooking.model.Review;
import com.tutorbooking.repository.AdminRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminService {
    private final AdminRepository adminRepository = new AdminRepository();
    private final UserService userService = new UserService();
    private final TutorService tutorService = new TutorService();
    private final BookingService bookingService = new BookingService();
    private final PaymentService paymentService = new PaymentService();
    private final ReviewService reviewService = new ReviewService();

    // Admin Authentication
    public Admin authenticateAdmin(String email, String password) {
        Admin admin = adminRepository.findByEmail(email);
        if (admin != null && admin.getPassword().equals(password) && admin.isActive()) {
            return admin;
        }
        return null;
    }

    // View all records
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    public List<Tutor> getAllTutors() {
        return tutorService.getAllTutors();
    }

    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    // Delete operations
    public boolean deleteUser(String userId) {
        return userService.deleteUser(userId);
    }

    public boolean deleteTutor(String tutorId) {
        return tutorService.deleteTutor(tutorId);
    }

    public boolean deleteBooking(String bookingId) {
        bookingService.deleteBooking(bookingId);
        return true;
    }

    public boolean deletePayment(String paymentId) {
        paymentService.deletePayment(paymentId);
        return true;
    }

    public boolean deleteReview(String reviewId) {
        reviewService.deleteReview(reviewId);
        return true;
    }

    // Statistics
    public int getTotalUsers() {
        return getAllUsers().size();
    }

    public int getTotalTutors() {
        return getAllTutors().size();
    }

    public int getTotalBookings() {
        return getAllBookings().size();
    }

    public long getTotalRevenue() {
        return Math.round(getAllPayments().stream()
                .filter(p -> "PAID".equals(p.getStatus()))
                .mapToDouble(Payment::getAmount)
                .sum() * 100.0) / 100;
    }

    public int getTotalReviews() {
        return getAllReviews().size();
    }

    public double getAverageRating() {
        List<Review> reviews = getAllReviews();
        if (reviews.isEmpty())
            return 0.0;
        return Math.round(reviews.stream()
                .mapToInt(Review::getRating)
                .average()
                .orElse(0.0) * 10.0) / 10.0;
    }

    public int getCompletedBookings() {
        return (int) getAllBookings().stream()
                .filter(b -> "COMPLETED".equals(b.getStatus()))
                .count();
    }

    public int getPendingBookings() {
        return (int) getAllBookings().stream()
                .filter(b -> "PENDING".equals(b.getStatus()))
                .count();
    }

    // Admin Management Methods
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Admin getAdminById(String id) {
        return adminRepository.findById(id);
    }

    public Admin getAdminByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    public void createAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    public void updateAdmin(String id, Admin admin) {
        adminRepository.update(id, admin);
    }

    public boolean deleteAdmin(String id) {
        return adminRepository.deleteById(id);
    }
}
