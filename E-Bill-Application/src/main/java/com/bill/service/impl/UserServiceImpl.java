package com.bill.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill.dto.BillDTO;
import com.bill.dto.PaymentDTO;
import com.bill.dto.UserDTO;
import com.bill.entity.Bill;
import com.bill.entity.User;
import com.bill.exception.ResourceNotFoundException;
import com.bill.repository.BillRepository;
import com.bill.repository.UserRepository;
import com.bill.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private BillRepository billRepository;


	@Override
	public User registerUser(User user) {
		if (userRepository.findByEmail(user.getEmail()) != null) {
			throw new ResourceNotFoundException("Email already registered!");
		}
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long id) {
		return this.userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
		
		
	}


	 @Override
	    public List<UserDTO> getAllUsers() {
	        List<User> users = userRepository.findAll();
	        return users.stream().map(user -> 
	            new UserDTO(
	                user.getId(),
	                user.getUsername(),
	                user.getEmail(),
	                user.getBills().stream()
	                    .map(bill -> new BillDTO(
	                        bill.getId(),
	                        bill.getUnitsConsumed(),
	                        bill.getAmountDue(),
	                        bill.getDueDate(),
	                        bill.getBillStatus().name()
	                    )).collect(Collectors.toList()),
	                user.getPayments().stream()
	                    .map(payment -> new PaymentDTO(
	                        payment.getId(),
	                        payment.getAmount(),
	                        payment.getPaymentDate(),
	                        payment.getStatus().name()
	                    )).collect(Collectors.toList())
	            )
	        ).collect(Collectors.toList());
	    }

	@Override
	public User updateUser(Long id, User userDetails) {
		User user = getUserById(id);
		user.setUsername(userDetails.getUsername());
		user.setEmail(userDetails.getEmail());
		user.setPassword(userDetails.getPassword());
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

//	public UserDetailsService userDetailsService() {
//		return new UserDetailsService() {
//			@Override
//			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//				User u = userRepository.findByEmail(username);
//				return (UserDetails) u;
//			}
//		};
//	}

}
