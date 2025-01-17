package com.novaes.treinamentos.usernr;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.novaes.treinamentos.nr.NR;
import com.novaes.treinamentos.office.Office;
import com.novaes.treinamentos.user.User;

@Service
public class UserNrService {
	
	private final UserNRRepository userNrRepository;
	
	public UserNrService(UserNRRepository userNrRepository) {
		this.userNrRepository=userNrRepository;
	}
	
	public void vinculedUserToNr(User user , Office office) {
		office.getListNR().forEach(nr -> {
            UserNR userNr = new UserNR();
            userNr.setUser(user);
            userNr.setNr(nr);
            userNr.setStatus(false);

            userNrRepository.save(userNr);
        });
	}
	
	public void vinculeOneNrToUser(User user , NR nr) {
		UserNR userNR = new UserNR();
		userNR.setNr(nr);
		userNR.setUser(user);
		userNR.setStatus(false);
		userNrRepository.save(userNR);
	}
	
	public UserNR findByUserIdAndNrNumber(Long userId, int nrNumber) {
        return userNrRepository.findByUserIdAndNrNumber(userId, nrNumber);
    }

    public void updateUserNR(UserNR userNR) {
        userNrRepository.save(userNR);
    }
	
	public List<UserNR> getListNrUserByUser (Long userId){
		return userNrRepository.findAllNrUserByUserId(userId);
	}
	
	public List<NR> getListNrByUser(Long userId){
		return userNrRepository.findAllNrByUserId(userId);
	}
	
	public List<UserNR> getListNrUserByUserWithQuestions(Long userId) {
        List<UserNR> userNRList = getListNrUserByUser(userId);

        return userNRList.stream()
                .filter(userNR -> userNR.getNr().getListQuestions() != null && !userNR.getNr().getListQuestions().isEmpty())
                .toList();
    }
	
	public void deleteUserNRByNrId(Long nrId) {
		userNrRepository.deleteUserNrByNrId(nrId);
	}

}
