package kr.co.chooz.user.domain;

import kr.co.chooz.user.domain.entitiy.ProviderType;
import kr.co.chooz.user.domain.entitiy.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatNoException;

class UserTest {

    @DisplayName("외부에서_소셜_회원가입에_필요한_정보로 유저를 생성한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "example1@Gamil.com,GOOGLE,providerId_1",
            "example2@kakao.com,KAKAO,providerId_2",
            "example3@naver.com,NAVER,providerId_3"
    }, delimiter = ',')
    void registerSocialLoginUser(String email, ProviderType providerType, String providerId) {
        // when & then
        assertThatNoException().isThrownBy(
                () -> User.builder()
                        .email(email)
                        .providerType(providerType)
                        .providerId(providerId)
                        .build()
        );
    }


}