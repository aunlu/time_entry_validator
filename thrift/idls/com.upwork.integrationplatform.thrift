namespace php Agora.Services.Thrift.test
namespace java com.upwork.integrationplatform.thrift
namespace perl Thrift.test

typedef string UID
typedef string Timestamp

// ============================== Structures ===================================

struct Ttest {
    1: UID                     uid
    2: Timestamp               createdTs
    3: Timestamp               updatedTs
}

struct TtestList {
    1: list<Ttest>   tests
}